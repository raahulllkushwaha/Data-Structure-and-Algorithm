class Solution {
    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }

        dfs(s, 0, l, r, 0, new StringBuilder());
        return new ArrayList<>(ans);
    }

    void dfs(String s, int i, int l, int r, int bal, StringBuilder sb) {
        if (bal < 0) return;

        if (i == s.length()) {
            if (l == 0 && r == 0 && bal == 0)
                ans.add(sb.toString());
            return;
        }

        char c = s.charAt(i);

        if (c == '(' && l > 0)
            dfs(s, i + 1, l - 1, r, bal, sb);

        if (c == ')' && r > 0)
            dfs(s, i + 1, l, r - 1, bal, sb);

        sb.append(c);

        if (c != ')')
            dfs(s, i + 1, l, r, bal + (c == '(' ? 1 : 0), sb);
        else if (bal > 0)
            dfs(s, i + 1, l, r, bal - 1, sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}