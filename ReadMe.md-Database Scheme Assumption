## Database Schema

### Tables

#### 1. **users**

- `user_id` (INT, Primary Key)
- `name` (VARCHAR)
- `email` (VARCHAR)
- `phone` (BIGINT)
- `role` (VARCHAR) — Values: `admin`, `manager`, `member`
- `credits` (INT) — Default: 0

#### 2. **meeting_rooms**

- `room_id` (INT, Primary Key)
- `room_name` (VARCHAR)
- `seating_capacity` (INT)
- `amenities` (VARCHAR) — Comma-separated list of amenities

#### 3. **bookings**

- `booking_id` (INT, Primary Key)
- `room_id` (INT, Foreign Key)
- `user_id` (INT, Foreign Key)
- `start_time` (DATETIME)
- `end_time` (DATETIME)
- `total_cost` (INT)
- `type` (VARCHAR) — Type of meeting

#### 4. **meeting_users**

- `meeting_id` (INT, Foreign Key)
- `user_id` (INT, Foreign Key)

### Example Schema

```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    credits INT DEFAULT 0
);

CREATE TABLE meeting_rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(255) NOT NULL,
    seating_capacity INT NOT NULL,
    amenities VARCHAR(255) NOT NULL
);

CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    user_id INT,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    total_cost INT NOT NULL,
    type VARCHAR(50) NOT NULL,
    FOREIGN KEY (room_id) REFERENCES meeting_rooms(room_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE meeting_users (
    meeting_id INT,
    user_id INT,
    FOREIGN KEY (meeting_id) REFERENCES bookings(booking_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
