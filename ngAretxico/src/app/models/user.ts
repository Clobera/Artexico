import { Artwork } from "./artwork";
import { Borough } from "./borough";
import { Exchange } from "./exchange";
import { InventoryItem } from "./inventory-item";

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
  borough: Borough; // assuming you have a Borough class defined
  portfolio: Artwork[];
  inventory: InventoryItem[];
  sales: Exchange[];
  purchases: Exchange[];
  bookmarkedArt: Artwork[];

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
    borough: Borough,
    portfolio: Artwork[],
    inventory: InventoryItem[],
    sales: Exchange[],
    purchases: Exchange[],
    bookmarkedArt: Artwork[]
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
    this.inventory = inventory;
    this.sales = sales;
    this.purchases = purchases;
    this.bookmarkedArt = bookmarkedArt;
  }
}


// export class User {
//   id: number;
//   email: string;
//   username: string;
//   password: string;
//   enabled: boolean;
//   role: string;
//   firstName: string;
//   lastName: string;
//   imageUrl: string;
//   bio: string;
//   accountType: string;
//   borough: Borough;
//   portfolio: Artwork[];
//   inventory: InventoryItem[];
//   sales: Exchange[];
//   purchases: Exchange[];
//   bookmarkedArt: Artwork[];
// }

//   constructor(
//     id: number = 0,
//     email: string = '',
//     username: string = '',
//     password: string = '',
//     enabled: boolean = true,
//     role: string = '',
//     firstName: string = '',
//     lastName: string = '',
//     imageUrl: string = '',
//     bio: string = '',
//     accountType: string = '',
//     borough: Borough = ,
//     portfolio: Artwork[],
//     inventory: InventoryItem[],
//     sales: Exchange[],
//     purchases: Exchange[],
//     bookmarkedArt: Artwork[]
//   ) {
//     this.id = id;
//     this.email = email;
//     this.username = username;
//     this.password = password;
//     this.enabled = enabled;
//     this.role = role;
//     this.firstName = firstName;
//     this.lastName = lastName;
//     this.imageUrl = imageUrl;
//     this.bio = bio;
//     this.accountType = accountType;
//     this.borough = borough;
//     this.portfolio = portfolio;
//     this.inventory = inventory;
//     this.sales = sales;
//     this.purchases = purchases;
//     this.bookmarkedArt = bookmarkedArt;
//   }
// }
