INSERT INTO student_entity (name) VALUES
                                      ('Aarav Sharma'),
                                      ('Diya Patel'),
                                      ('Dishant Verma'),
                                      ('Neha Iyer'),
                                      ('Kabir Singh'),
                                      ('Ananya Gupta'),
                                      ('Vivaan Mehta'),
                                      ('Ishita Kapoor'),
                                      ('Aditya Joshi'),
                                      ('Riya Nair');
INSERT INTO professor_entity (title) VALUES
                                         ('Dr. Amit Sharma'),
                                         ('Dr. Priya Verma'),
                                         ('Dr. Rajesh Gupta'),
                                         ('Dr. Neha Kapoor'),
                                         ('Dr. Vivek Singh');
INSERT INTO subject_entity (title, professor_subject) VALUES
                                                          ('Mathematics',1),
                                                          ('Physics',1),
                                                          ('Chemistry',2),
                                                          ('Biology',3),
                                                          ('English',4),
                                                          ('Computer Science',5),
                                                          ('History',2),
                                                          ('Economics',3);
INSERT INTO admission_record_entity (fees, student_admission_record) VALUES
                                                                         (50000,1),
                                                                         (51000,2),
                                                                         (52000,3),
                                                                         (53000,4),
                                                                         (54000,5),
                                                                         (55000,6),
                                                                         (56000,7),
                                                                         (57000,8),
                                                                         (58000,9),
                                                                         (59000,10);
INSERT INTO Student_Professor (student_id, professor_id) VALUES
                                                             (1,1),
                                                             (1,2),

                                                             (2,2),
                                                             (2,3),

                                                             (3,1),
                                                             (3,4),

                                                             (4,5),

                                                             (5,1),
                                                             (5,3),

                                                             (6,2),

                                                             (7,4),

                                                             (8,5),

                                                             (9,1),

                                                             (10,2);
INSERT INTO Student_Subject (student_id, subject_id) VALUES
                                                         (1,1),
                                                         (1,2),
                                                         (1,6),

                                                         (2,3),
                                                         (2,5),

                                                         (3,1),
                                                         (3,4),

                                                         (4,6),

                                                         (5,7),
                                                         (5,8),

                                                         (6,2),

                                                         (7,3),

                                                         (8,4),

                                                         (9,5),

                                                         (10,1),
                                                         (10,8);