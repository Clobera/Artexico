export class User {
  id: number;
  email: string;
  username: string;
  password: string;
  enabled: boolean;
  role: string;
  firstName: string;
  lastName: string;
  imageUrl: string;
  bio: string;

  constructor(
    id: number = 0,
    email: string = '',
    username: string = '',
    password: string = '',
    enabled: boolean = true,
    role: string = '',
    firstName: string = '',
    lastName: string = '',
    imageUrl: string = '',
    bio: string = ''
  ) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.bio = bio;
  }
}
