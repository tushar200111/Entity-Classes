package com.hsbc.presentation;

//
////        CreditScheduler.initializeCredits();
//        //AdminService service = new AdminServiceImpl();
//
////        User user = new User(1,"Arya","abc@gmail.com","1234567890","Admin");
////        User user2 = new User(2,"Tushar","def@gmail.com","1234567898","Manager");
////        if(service.addUser(user))
////            System.out.println("user added");
////
////        if(service.addUser(user2))
////            System.out.println("user added");
//
////        if(service.findUserById(1) != null)
////            System.out.println("user found");
////        User user2 = new User(1,"Arya Pratap Singh","abc@gmail.com","1234567890","Admin");
////
////        if(service.updateUser(user2))
////            System.out.println("user updated");
//
////        if(service.removeUser(1))
////            System.out.println("user deleted");
//
//
////        List<User> users = service.getAllMemebrs();
////
////        System.out.println(users);
//
////        Amenity amenity = new Amenity(1,"water dispenser",100);
////
////        if(service.createAmenity(amenity))
////              System.out.println("amenity added");
//
////        System.out.println(service.getAmenityById(1));
//
////        Amenity amenity = new Amenity(1, "water dispenser", 1000);
////        if(service.createAmenity(amenity))
////            System.out.println("amenity added2");
//
////        if(service.RemoveAmenity(1))
////            System.out.println("amenity added3");
////
//
////        List<Amenity> list = service.getAllAmenities();
////        System.out.println(list);
//
//
////        MeetingRoom room = new MeetingRoom(1,10,"abc","def,ghi");
////        if(service.makeMeetingRoom(room))
////            System.out.println("room created");
//
////        System.out.println(service.getMeetingRoomById(1).getRoomName());
//
////        MeetingRoom room = new MeetingRoom(1,10,"abcd","def,ghi");
////        if(service.updateMeetingRoom(room))
////            System.out.println("room updated");
////
////        if(service.deleteMeetingRoom(1))
////             System.out.println("room del");
//
////        List<MeetingRoom> rooms = service.getAllMeetingRooms();
////        System.out.println(rooms.get(0).getRoomName());
//
//       // System.out.println(service.getBookingDetails().get(0).getType());
//
////        UserServiceImpl service1 = new UserServiceImpl();
////
////        System.out.println(service1.getUserById(3).getName());
//
//        ManagerServiceImpl managerService = new ManagerServiceImpl();
//
//        //System.out.println(managerService.searchUsers("Ar"));
////
////        int bookingId = 1;
////        int roomId = 6;
////        int userId = 3;
////        LocalDateTime startTime = LocalDateTime.of(2024, 8, 21, 9, 0); // 21st Aug 2024, 9:00 AM
////        LocalDateTime endTime = LocalDateTime.of(2024, 8, 21, 11, 0);  // 21st Aug 2024, 11:00 AM
////        int totalCost = 500;
////        String type = "Conference Call";
//
//        // Creating a Booking object
////        Booking booking = new Booking(bookingId, roomId, userId, startTime, endTime, totalCost, type);
////        System.out.println(managerService.bookMeeting(booking));
//
////System.out.println(managerService.addUserToMeeting(3,4));
//
//       // System.out.println(managerService.viewBookings(3));
//
//    //    System.out.println(managerService.getMeetingDetails(3).getType());
//
//                package com.hsbc.ui;

        import com.hsbc.model.Amenity;
        import com.hsbc.model.Booking;
        import com.hsbc.model.MeetingRoom;
        import com.hsbc.model.User;
        import com.hsbc.services.AdminService;
        import com.hsbc.services.AdminServiceImpl;
        import com.hsbc.services.ManagerService;
        import com.hsbc.services.ManagerServiceImpl;
        import com.hsbc.services.UserService;
        import com.hsbc.services.UserServiceImpl;

        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.time.format.DateTimeParseException;
        import java.util.List;
        import java.util.Scanner;

public class ui {
    private static final Scanner scanner = new Scanner(System.in);

    private final AdminService adminService = new AdminServiceImpl();
    private final ManagerService managerService = new ManagerServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public void start() {
        while (true) {
            System.out.println("1. Admin Operations");
            System.out.println("2. Manager Operations");
            System.out.println("3. User Operations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    adminOperations();
                    break;
                case 2:
                    managerOperations();
                    break;
                case 3:
                    userOperations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void adminOperations() {
        System.out.println("Admin Operations:");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Update User");
        System.out.println("4. View All Users");
        System.out.println("5. Create Amenity");
        System.out.println("6. Remove Amenity");
        System.out.println("7. Update Amenity");
        System.out.println("8. View All Amenities");
        System.out.println("9. Create Meeting Room");
        System.out.println("10. Remove Meeting Room");
        System.out.println("11. Update Meeting Room");
        System.out.println("12. View All Meeting Rooms");
        System.out.println("13. View All Bookings");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                removeUser();
                break;
            case 3:
                updateUser();
                break;
            case 4:
                viewAllUsers();
                break;
            case 5:
                createAmenity();
                break;
            case 6:
                removeAmenity();
                break;
            case 7:
                updateAmenity();
                break;
            case 8:
                viewAllAmenities();
                break;
            case 9:
                createMeetingRoom();
                break;
            case 10:
                removeMeetingRoom();
                break;
            case 11:
                updateMeetingRoom();
                break;
            case 12:
                viewAllMeetingRooms();
                break;
            case 13:
                viewAllBookings();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void managerOperations() {
        System.out.println("Manager Operations:");
        System.out.println("1. Book Meeting");
        System.out.println("2. Add User to Meeting");
        System.out.println("3. Search Users");
        System.out.println("4. View Bookings");
        System.out.println("5. View Meeting Details");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                bookMeeting();
                break;
            case 2:
                addUserToMeeting();
                break;
            case 3:
                searchUsers();
                break;
            case 4:
                viewBookings();
                break;
            case 5:
                viewMeetingDetails();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void userOperations() {
        System.out.println("User Operations:");
        System.out.println("1. View My Meetings");
        System.out.println("2. View My Details");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                viewMyMeetings();
                break;
            case 2:
                viewMyDetails();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Admin Methods
    private void addUser() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();

        User user = new User(userId, name, email, phone, role);
        boolean success = adminService.addUser(user);
        System.out.println(success ? "User added successfully." : "Failed to add user.");
    }

    private void removeUser() {
        System.out.print("Enter user ID to remove: ");
        int userId = scanner.nextInt();
        boolean success = adminService.removeUser(userId);
        System.out.println(success ? "User removed successfully." : "Failed to remove user.");
    }

    private void updateUser() {
        System.out.print("Enter user ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();

        User user = new User(userId, name, email, phone, role);
        boolean success = adminService.updateUser(user);
        System.out.println(success ? "User updated successfully." : "Failed to update user.");
    }

    private void viewAllUsers() {
        List<User> users = adminService.getAllMemebrs();
        users.forEach(System.out::println);
    }

    private void createAmenity() {
        System.out.print("Enter amenity ID: ");
        int amenityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter amenity name: ");
        String amenityName = scanner.nextLine();
        System.out.print("Enter credit cost: ");
        int creditCost = scanner.nextInt();

        Amenity amenity = new Amenity(amenityId, amenityName, creditCost);
        boolean success = adminService.createAmenity(amenity);
        System.out.println(success ? "Amenity created successfully." : "Failed to create amenity.");
    }

    private void removeAmenity() {
        System.out.print("Enter amenity ID to remove: ");
        int amenityId = scanner.nextInt();
        boolean success = adminService.RemoveAmenity(amenityId);
        System.out.println(success ? "Amenity removed successfully." : "Failed to remove amenity.");
    }

    private void updateAmenity() {
        System.out.print("Enter amenity ID to update: ");
        int amenityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new amenity name: ");
        String amenityName = scanner.nextLine();
        System.out.print("Enter new credit cost: ");
        int creditCost = scanner.nextInt();

        Amenity amenity = new Amenity(amenityId, amenityName, creditCost);
        boolean success = adminService.updateAmenity(amenity);
        System.out.println(success ? "Amenity updated successfully." : "Failed to update amenity.");
    }

    private void viewAllAmenities() {
        List<Amenity> amenities = adminService.getAllAmenities();
        amenities.forEach(System.out::println);
    }

    private void createMeetingRoom() {
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        System.out.print("Enter seating capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter amenities: ");
        String amenities = scanner.nextLine();

        MeetingRoom meetingRoom = new MeetingRoom(roomId, seatingCapacity, roomName, amenities);
        boolean success = adminService.makeMeetingRoom(meetingRoom);
        System.out.println(success ? "Meeting room created successfully." : "Failed to create meeting room.");
    }

    private void removeMeetingRoom() {
        System.out.print("Enter room ID to remove: ");
        int roomId = scanner.nextInt();
        boolean success = adminService.deleteMeetingRoom(roomId);
        System.out.println(success ? "Meeting room removed successfully." : "Failed to remove meeting room.");
    }

    private void updateMeetingRoom() {
        System.out.print("Enter room ID to update: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new room name: ");
        String roomName = scanner.nextLine();
        System.out.print("Enter new seating capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new amenities: ");
        String amenities = scanner.nextLine();

        MeetingRoom meetingRoom = new MeetingRoom(roomId, seatingCapacity, roomName, amenities);
        boolean success = adminService.updateMeetingRoom(meetingRoom);
        System.out.println(success ? "Meeting room updated successfully." : "Failed to update meeting room.");
    }

    private void viewAllMeetingRooms() {
        List<MeetingRoom> meetingRooms = adminService.getAllMeetingRooms();
        meetingRooms.forEach(System.out::println);
    }

    private void viewAllBookings() {
        List<Booking> bookings = adminService.getBookingDetails();
        bookings.forEach(System.out::println);
    }

    // Manager Methods
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private void bookMeeting() {
        System.out.print("Enter booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        while (startTime == null) {
            System.out.print("Enter start time (yyyy-MM-dd HH:mm:ss): ");
            String startTimeInput = scanner.nextLine();
            try {
                startTime = LocalDateTime.parse(startTimeInput, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please enter the date and time in the format yyyy-MM-dd HH:mm:ss.");
            }
        }

        while (endTime == null) {
            System.out.print("Enter end time (yyyy-MM-dd HH:mm:ss): ");
            String endTimeInput = scanner.nextLine();
            try {
                endTime = LocalDateTime.parse(endTimeInput, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please enter the date and time in the format yyyy-MM-dd HH:mm:ss.");
            }
        }

        System.out.print("Enter total cost: ");
        int totalCost = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter meeting type: ");
        String type = scanner.nextLine();

        Booking booking = new Booking(bookingId, roomId, userId, startTime, endTime, totalCost, type);
        boolean success = managerService.bookMeeting(booking);
        System.out.println(success ? "Meeting booked successfully." : "Failed to book meeting.");
    }

    private void addUserToMeeting() {
        System.out.print("Enter booking ID: ");
        int bookingId = scanner.nextInt();
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        boolean success = managerService.addUserToMeeting(bookingId, userId);
        System.out.println(success ? "User added to meeting successfully." : "Failed to add user to meeting.");
    }

    private void searchUsers() {
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        List<User> users = managerService.searchUsers(keyword);
        users.forEach(System.out::println);
    }

    private void viewBookings() {
        System.out.print("Enter manager ID: ");
        int managerId = scanner.nextInt();
        List<Booking> bookings = managerService.viewBookings(managerId);
        bookings.forEach(System.out::println);
    }

    private void viewMeetingDetails() {
        System.out.print("Enter booking ID: ");
        int bookingId = scanner.nextInt();
        Booking booking = managerService.getMeetingDetails(bookingId);
        System.out.println(booking);
    }

    // User Methods
    private void viewMyMeetings() {
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        List<Booking> bookings = userService.viewUserMeetings(userId);
        bookings.forEach(System.out::println);
    }

    private void viewMyDetails() {
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        User user = userService.getUserById(userId);
        System.out.println(user);
    }

    public static void main(String[] args) {
        new ui().start();
    }
}
