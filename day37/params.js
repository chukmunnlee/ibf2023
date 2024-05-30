/*
function add(x, y) {
   return x + y
}
*/

// lambdas, anonymous functions
const add = function(x, y) { return x + y }
const minus = (x, y) => x - y

const apply = (f, a, b) => {
   console.info('> f: ', f)
   return f(a, b)
}

console.info('add: ', add, typeof add)
console.info('minus: ', minus, typeof minus)

const a = 3
const b = 7

console.info(
   //add(a, b)
   apply(add, a, b),
   apply(minus, a, b),
)

