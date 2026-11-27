db.students.aggregate([
    {
        $group: {
            _id: "$department",
            totalStudents: { $sum: 1 }
        }
    },
    {
        $sort: { totalStudents: -1 }
    },
    {
        $limit: 1
    }
]);