
const names = [ 'fred', 'barney', 'wilma', 'betty' ]

const newList = names
	.filter(value => value.length > 4)
	.map(value => value.toUpperCase())

console.info('>>>> names: ', names);
console.info('>>>> newList: ', newList);

