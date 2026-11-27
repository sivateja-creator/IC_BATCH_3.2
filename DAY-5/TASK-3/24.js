db.students.find({
    city: {
        $nin: ["Hyderabad", "Bangalore"]
    }
});