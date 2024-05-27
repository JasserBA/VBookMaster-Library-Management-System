## Features

### User Features
- **Book Borrowing**: Users can borrow books by clicking 'Add to List'.
- **Access Books**: Users can view a list of borrowed books and access their PDF versions.
- **Return Books**: Users can return books through the system.

### Admin Features
- **User Management**: Admins have full CRUD (Create, Read, Update, Delete) capabilities to manage the list of users.
- **Borrowing History**: Admins can view the borrowing history, including:
  - User ID and name
  - Book ID and name
  - Date of borrowing and return

## Technologies Used
- **Java**: Core application logic
- **MySQL**: Database management
- **PHP**: Web functionalities and integration
- **Swing**: User interface for the desktop application

## Installation
1. Clone the repository: `git clone https://github.com/yourusername/VBookMaster.git`
2. Set up the MySQL database with the provided schema and data files.
3. **Important**: Ensure that your MySQL server is running on port `8111`. The connection string in the Java code is configured as follows:
If you are using a different port, update the connection string accordingly in the Java code.
4. Configure the database connection in the Java application with the appropriate username and password. The default configuration is:
- **Username**: root
- **Password**: (empty)

5. Run the application using your preferred IDE or build tool.

## Usage
- **Users**: Register, borrow books, view borrowed books, and return books.
- **Admins**: Manage users, view borrowing history, and perform administrative tasks.

## Contribution
Feel free to fork this repository and contribute through pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.

## Warning
Do not remove or change the port `8111` in the database connection string unless your MySQL server is configured to use a different port. Update the port only if necessary and ensure your server is correctly configured to use the specified port.
