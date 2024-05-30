const power = (x, n) => {
   let sum = 1
   for (let i = 0; i < n; i++)
      sum *= x
   return sum
}

const mkPower = (n) => {
   return (x) => {
      let sum = 1
      for (let i = 0; i < n; i++)
         sum *= x
      return sum
   }
}

const square = mkPower(2)
const cube = mkPower(3)
const quad = (x) => {
   let sum = 1
   for (let i = 0; i < 4; i++)
      sum *= x
   return sum
}

console.info('>> 4^2 = ', square(4))
console.info('>> 4^3 = ', cube(4))