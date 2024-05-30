const hello = (name) => {
   console.info(`Hello ${name}`)
}

const mkGreetings = (name) => {
	const f = () => {
      console.info(`Hello ${name}`)
   }
   return f
}

hello('fred')

const helloFred = mkGreetings('fred')
const helloBarney = mkGreetings('barney')
const abc = mkGreetings
const helloWilma = abc('wilma')


console.info('helloFred: ', helloFred)

helloFred()
helloBarney()
helloWilma()
