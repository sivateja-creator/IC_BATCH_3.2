db.students.aggregate([
    {
        $group: {
            _id: null,
            averageAge: { $avg: "$age" }
        }
    },
    {
        $lookup: {
            from: "students",
            pipeline: [
                {
                    $group: {
                        _id: null,
                        averageAge: { $avg: "$age" }
                    }
                }
            ],
            as: "average"
        }
    },
    {
        $unwind: "$average"
    },
    {
        $match: {
            $expr: {
                $gt: ["$average.averageAge", 0]
            }
        }
    }
]);

db.students.aggregate([
    { $sort: { age: -1 } },
    { $limit: 1 }
]);

db.students.aggregate([
    {
        $group: {
            _id: "$department",
            totalStudents: { $sum: 1 }
        }
    },
    { $sort: { totalStudents: -1 } },
    { $limit: 1 }
]);

db.students.find({
    city: { $nin: ["Hyderabad", "Bangalore"] }
});

db.students.aggregate([
    {
        $group: {
            _id: "$department",
            totalStudents: { $sum: 1 }
        }
    },
    { $sort: { totalStudents: -1 } }
]);