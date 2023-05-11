import { User } from './user';

export class Borough {
  id: number;
  name: string;
  users: Array<User>;

  constructor(id: number = 0, name: string = '', users: Array<User> = []) {
    this.id = id;
    this.name = name;
    this.users = users;
  }
}
