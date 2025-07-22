CREATE TABLE AppUser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO AppUser (name, email)
VALUES
('Jane Smith', 'jane@example.com'),
('Alice Johnson', 'alice@example.com'),
('Bob Williams', 'bob@example.com');


INSERT INTO tasks (title, description, is_completed)
VALUES ('Submit report', 'Submit weekly report to manager', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Team meeting', 'Attend Monday morning team sync', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Code review', 'Review pull requests on GitHub', true);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Write tests', 'Add unit tests for the task service', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Update documentation', 'Revise project README and user guide', true);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Deploy to production', 'Deploy latest build to live server', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Fix bug #452', 'Resolve null pointer exception in login module', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Send invoice', 'Email invoice to client for completed project', true);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Backup database', 'Run full backup before version upgrade', false);

INSERT INTO tasks (title, description, is_completed)
VALUES ('Design new feature', 'Sketch out UI/UX for feedback form module', false);


-----------------------------------------------------------------------------
INSERT INTO Student (name, email, roll_Number,Status) VALUES
('Ali Khan', 'ali.khan@example.com', 'R2025-001','ACTIVE'),
('Fatima Zahra', 'fatima.zahra@example.com', 'R2025-002','ACTIVE'),
('Ahmed Raza', 'ahmed.raza@example.com', 'R2025-003','ACTIVE'),
('Sara Iqbal', 'sara.iqbal@example.com', 'R2025-004','ACTIVE'),
('Bilal Aslam', 'bilal.aslam@example.com', 'R2025-005','ACTIVE');


-------------------------------------------------------------------------------------
INSERT INTO course (title) VALUES ('Java for Beginners');
INSERT INTO course (title) VALUES ('Advanced Spring Boot');
INSERT INTO course (title) VALUES ('Database Design');
-------------------------------------------------------------------------------------
INSERT INTO Review (description, rating, course_id) VALUES
('Great course, very informative!', 5, 1),
('Average content, needs improvement.', 3, 2),
('Loved the hands-on examples!', 4, 1),
('Too theoretical, lacked examples.', 2, 3),
('Excellent teaching style!', 5, 2);
--------------------------------------------------------------------------------------