export class User {
  userId: string;
  username: string;
  password: string;
  role: string;

  constructor(userId: string="", username: string="", password: string="", role: string="") {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
