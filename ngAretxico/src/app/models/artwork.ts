import { ArtworkMedium } from './artwork-medium';
import { Material } from './material';
import { Movement } from './movement';
import { Theme } from './theme';
import { User } from './user';

export class Artwork {
  id: number;
  title: string;
  price: number;
  image: string;
  forSale: boolean;
  enabled: boolean;
  dimensionHeight: number;
  dimensionWidth: number;
  dimensionLength: number;
  createdAt: Date;
  artworkMedium: ArtworkMedium;
  theme: Theme;
  artist: User;
  bookmarks: Array<User>;
  materials: Array<Material>;
  movements: Array<Movement>;

  constructor(
    id: number = 0,
    title: string = '',
    price: number = 0,
    image: string = '',
    forSale: boolean = false,
    enabled: boolean = true,
    dimensionHeight: number = 0,
    dimensionWidth: number = 0,
    dimensionLength: number = 0,
    createdAt: Date = new Date(),
    artworkMedium: ArtworkMedium,
    theme: Theme,
    artist: User,
    bookmarks: Array<User> = [],
    materials: Array<Material> = [],
    movements: Array<Movement> = []
  ) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.image = image;
    this.forSale = forSale;
    this.enabled = enabled;
    this.dimensionHeight = dimensionHeight;
    this.dimensionWidth = dimensionWidth;
    this.dimensionLength = dimensionLength;
    this.createdAt = createdAt;
    this.artworkMedium = artworkMedium;
    this.theme = theme;
    this.artist = artist;
    this.bookmarks = bookmarks;
    this.materials = materials;
    this.movements = movements;
  }
}
