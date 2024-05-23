let p = new Promise(
	(resolve, reject) => {
		setTimeout(
			() => { 
				//reject('failed!!!')
				resolve('setTimeout completed')
			}, 1000) }
)

p.then(
		(value) => {
			// resolve()
			console.info('>> promise resolved', value)
			//throw "This is an error"
			console.info('>>>> 2nd then: ', value)
			//return (new Date()) // ??? 
			//return Promise.resolve(new Date())
			throw "hello"
		})
	.then(
		(value) => { console.info('>>> 2nd then: ', value) }, // then
		(value) => { console.error('>>>> catch in the 2nd then: ', value) } // catch
	)
	.catch((value) => { console.error(`ERROR ${value}`)
			//return "value from the 1st catch "
			throw "value from the 1st catch "
			//return Promise.reject("value from the 1st catch")
	})
	.then(value => console.info('>>> 3rd then: ', value))
	.catch(value => console.error('>>> 2nd catch: ', value))
	.finally(() => {
		console.info('>>> in finally ')
	})

console.info('>>> after promise', p)
