db.students.aggregate([
    {
        $lookup: {
            from: "students",
            pipeline: [
                { $sort: { age: -1 } },
                { $limit: 1 }
            ],
            as: "oldestStudent"
        }
    },
    {
        $unwind: "$oldestStudent"
    },
    {
        $replaceRoot: {
            newRoot: "$oldestStudent"
        }
    },
    {
        $limit: 1
    }
]);