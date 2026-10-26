/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (classFunction === null || classFunction === undefined || typeof classFunction !== 'function') {
        return false;
    }

    if (obj === null || obj === undefined) {
        return false;
    }

    let currPrototype = Object.getPrototypeOf(obj);
    
    while (currPrototype !== null) {
        if (currPrototype === classFunction.prototype) {
            return true;
        }
        currPrototype = Object.getPrototypeOf(currPrototype);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */