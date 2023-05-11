import { Artwork } from "./artwork";

export class Theme {
  id: number;
  name: string;
  artwork: Array<Artwork>;

  constructor(id: number = 0, name: string = '', artwork: Array<Artwork> = []) {
    this.id = id;
    this.name = name;
    this.artwork = artwork;
  }
}
