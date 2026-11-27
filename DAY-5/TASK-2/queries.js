db.students.find().sort({ age: -1 }).limit(3);

db.students.countDocuments();

db.students.aggregate([
    { $group: { _id: null, averageAge: { $avg: "$age" } } }
]);

db.students.find().sort({ age: 1 }).limit(1);

db.students.find().sort({ age: -1 }).limit(1);

db.students.aggregate([
    { $group: { _id: "$department", totalStudents: { $sum: 1 } } }
]);

db.students.aggregate([
    { $group: { _id: "$department", averageAge: { $avg: "$age" } } }
]);

db.students.aggregate([
    { $group: { _id: "$department", totalStudents: { $sum: 1 } } },
    { $match: { totalStudents: { $gt: 2 } } }
]);

db.students.updateOne(
    { studentId: 107 },
    { $set: { city: "Chennai" } }
);

db.students.deleteOne({ studentId: 110 });