const add = function(x, y) { return x + y }
const minus = (x, y) => x - y

// f - function
// a, b - numbers
const apply = (f, a, b) => {
   //console.info('> f: ', f)
   // returning a scalar, object, array, function
   return f(a, b)
}

let a = 6
let b = 10

apply(add, 
   apply(add, a, b), 
   apply(minus, a, b)
)

console.info(
   //add(a, b)
   apply(add, a, b),
   apply(minus, a, b),
)

/*
console.info(
   apply(
      (x, y) => { return [x, y] },
      "hello", "world"
   )
)

console.info(
   apply(
      (x, y) => { return x + y },
      "hello", "world"
   )
)
*/