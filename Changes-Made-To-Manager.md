## Changes Made

### ManagerDao Changes

- **`ManagerDao` Interface:**
  - Added method `boolean validateAmenities(Booking booking);` to validate required amenities for a booking based on the meeting type.

- **`ManagerDaoImpl` Implementation:**
  - **`bookMeeting(Booking booking)`**:
    - Added validation for amenities using `validateAmenities()`.
    - Proceed with booking only if amenities are validated.
  - **`validateAmenities(Booking booking)`**:
    - Implemented logic to check if the meeting room includes all required amenities based on the meeting type (Classroom Training, Online Training, Conference Call, Business).

### Service Layer Notes

- **`ManagerService` Interface:**
  - Defined methods to interact with the DAO layer, including booking meetings, adding users to meetings, searching users, viewing bookings, and getting meeting details.
  
- **`ManagerServiceImpl` Implementation:**
  - **`bookMeeting(Booking booking)`**:
    - Added validation call to `validateAmenities()` from the DAO before proceeding with booking.
  - Other methods delegate calls directly to the DAO implementation.
  - Ensured that business logic is separated from data access logic by using the DAO layer for database operations.

## Summary

- Added functionality to validate required amenities before booking a meeting room.
- Updated service layer to incorporate validation and handle interactions with the DAO layer.

