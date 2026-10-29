class Solution {
    List<Integer>[] adj;
    int[][] up;
    int[] depth, tin, tout, parent;
    int[] currentMask;
    int LOG, timer, n;
    Fenwick bit;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        timer = 0;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++){ 
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[n][LOG];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        currentMask = new int[n];

        for (int i = 0; i < n; i++) {
            currentMask[i] = 1 << (s.charAt(i) - 'a');
        }

        buildEulerTour();

        bit = new Fenwick(n);

        for (int u = 0; u < n; u++) {
            rangeXor(tin[u], tout[u], currentMask[u]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int delta = currentMask[u] ^ newMask;

                rangeXor(tin[u], tout[u], delta);
                currentMask[u] = newMask;

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = findLCA(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ currentMask[lca];

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private void buildEulerTour() {
        int[] iter = new int[n];
        int[] stack = new int[n];
        int top = 0;

        stack[0] = 0;
        parent[0] = 0;
        depth[0] = 0;

        for (int j = 0; j < LOG; j++) {
            up[0][j] = 0;
        }

        tin[0] = timer++;

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                up[v][0] = u;

                for (int j = 1; j < LOG; j++) {
                    up[v][j] = up[up[v][j - 1]][j - 1];
                }

                tin[v] = timer++;
                stack[++top] = v;

            } else {
                tout[u] = timer - 1;
                top--;
            }
        }
    }

    private int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    private void rangeXor(int l, int r, int value) {
        bit.update(l, value);

        if (r + 1 < n) {
            bit.update(r + 1, value);
        }
    }

    class Fenwick {
        int[] tree;
        int size;

        Fenwick(int n) {
            size = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= size; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}