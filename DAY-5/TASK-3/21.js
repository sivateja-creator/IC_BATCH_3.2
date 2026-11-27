db.students.aggregate([
    {
        $set: {
            averageAge: {
                $avg: "$age"
            }
        }
    },
    {
        $match: {
            $expr: {
                $gt: ["$age", "$averageAge"]
            }
        }
    },
    {
        $unset: "averageAge"
    }
]);