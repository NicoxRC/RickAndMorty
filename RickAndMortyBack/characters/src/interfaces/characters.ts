import type { episodeType } from '../types/episode';
import type { locationType } from '../types/location';
import type { originType } from '../types/origin';

export interface CharactersInterface {
  _id: number;
  name: string;
  status: string;
  species: string;
  type: string;
  gender: string;
  image: string;
  origin: originType[];
  location: locationType[];
  episode: episodeType[];
}
