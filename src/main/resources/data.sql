--CREATE TABLE AppUser (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    name VARCHAR(100),
--    email VARCHAR(100),
--    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--);


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
--INSERT INTO Student (name, email, roll_Number,Status) VALUES
--('Ali Khan', 'ali.khan@example.com', 'R2025-001','ACTIVE'),
--('Fatima Zahra', 'fatima.zahra@example.com', 'R2025-002','ACTIVE'),
--('Ahmed Raza', 'ahmed.raza@example.com', 'R2025-003','ACTIVE'),
--('Sara Iqbal', 'sara.iqbal@example.com', 'R2025-004','ACTIVE'),
--('Bilal Aslam', 'bilal.aslam@example.com', 'R2025-005','ACTIVE');


-------------------------------------------------------------------------------------
INSERT INTO course (title) VALUES ('Java for Beginners');
INSERT INTO course (title) VALUES ('Advanced Spring Boot');
INSERT INTO course (title) VALUES ('Database Design');
-------------------------------------------------------------------------------------
--INSERT INTO Review (description, rating, course_id) VALUES
--('Great course, very informative!', 5, 1),
--('Average content, needs improvement.', 3, 2),
--('Loved the hands-on examples!', 4, 1),
--('Too theoretical, lacked examples.', 2, 3),
--('Excellent teaching style!', 5, 2);
--------------------------------------------------------------------------------------
INSERT INTO users (name, email, birthday)
VALUES
  ('John Doe', 'john.doe@example.com', '1990-05-12'),
  ('Jane Smith', 'jane.smith@example.com', '1988-09-25'),
  ('Michael Brown', 'michael.brown@example.com', '1992-01-10'),
  ('Emily Johnson', 'emily.johnson@example.com', '1995-06-18'),
  ('William Davis', 'william.davis@example.com', '1985-03-03'),
  ('Olivia Garcia', 'olivia.garcia@example.com', '1999-12-05'),
  ('Noah Martinez', 'noah.martinez@example.com', '2000-04-22'),
  ('Sophia Wilson', 'sophia.wilson@example.com', '1987-07-11'),
  ('Liam Anderson', 'liam.anderson@example.com', '1991-11-30'),
  ('Ava Thomas', 'ava.thomas@example.com', '1993-08-16');
--------------------------------------------------------------------------------------
INSERT INTO posts (title, content, author, user_id)
VALUES
  ('Post 1', 'This is the content of post 1.', 'John Doe', 1),
  ('Post 2', 'This is the content of post 2.', 'Jane Smith', 2),
  ('Post 3', 'A short post.', 'Michael Brown', 3),
  ('Post 4', 'Another blog post content here.', 'Emily Johnson', 4),
  ('Post 5', 'Tech tips and tricks.', 'William Davis', 5),
  ('Post 6', 'Opinion article about AI.', 'Olivia Garcia', 6),
  ('Post 7', 'Travel blog entry.', 'Noah Martinez', 7),
  ('Post 8', 'Fitness and health content.', 'Sophia Wilson', 8),
  ('Post 9', 'Book review.', 'Liam Anderson', 9),
  ('Post 10', 'Daily journal.', 'Ava Thomas', 10);
--------------------------------------------------------------------------------------