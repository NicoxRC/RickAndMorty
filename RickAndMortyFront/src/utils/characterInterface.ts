import { CardInterface } from './cardInterface';

export interface characterInterface extends CardInterface {
  species: string;
  type: string;
  gender: string;
  location: {
    name: string;
    url: string;
  };
  episode: string[];
  url: string;
  created: string;
}
