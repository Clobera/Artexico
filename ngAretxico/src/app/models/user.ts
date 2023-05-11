import { Artwork } from "./artwork";
import { Borough } from "./borough";

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
  accountType: string;
  borough: Borough;
  portfolio: Array<Artwork>;
  bookmarkedArt: Array<Artwork>;

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
    bio: string = '',
    accountType: string = '',
    borough: Borough = new Borough(),
    portfolio: Array<Artwork> = [],
    bookmarkedArt: Array<Artwork> = []
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
    this.accountType = accountType;
    this.borough = borough;
    this.portfolio = portfolio;
    this.bookmarkedArt = bookmarkedArt;
  }
}

