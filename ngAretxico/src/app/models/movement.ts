import { Artwork } from "./artwork";

export class Movement {
  id: number;
  name: string;
  artworks: Array<Artwork>;

  constructor(id: number = 0, name: string = '', artworks: Array<Artwork> = []) {
    this.id = id;
    this.name = name;
    this.artworks = artworks;
  }
}
