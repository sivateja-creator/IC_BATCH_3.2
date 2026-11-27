db.students.find();

db.students.find({}, { name: 1, department: 1, _id: 0 });

db.students.find({ studentId: 105 });

db.students.find({ age: { $gt: 21 } });

db.students.find({ department: "CSE" });

db.students.find({ city: "Bangalore" });

db.students.find({ age: { $gte: 20, $lte: 22 } });

db.students.find({ department: { $in: ["CSE", "ECE", "IT"] } });

db.students.find({ name: { $regex: "^A", $options: "i" } });

db.students.find().sort({ age: 1 });