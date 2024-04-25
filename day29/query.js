
db.games.aggregate([
	{ 
		$match: { 
			name: { $regex: "ticket", $options: "i" }
		} 
	},
	{
		$sort: { ranking: -1 }
	},
	{
		$project: { _id: "$gid", name: 1, year: 1, ranking: 1, users_rated: 1, url: 1, image: 1 }
	},
	{
		$lookup: {
			from: "comments",
			foreignField: "gid",
			localField: "_id",
			pipeline: [
				{ $sort: { rating: -1 } },
				{ $limit: 5 }
			],
			as: "reviews"
		}
	}
])
