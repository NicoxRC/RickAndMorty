import type { Info } from './infoApiInterface';
import type { Result } from './resultsApiInterface';

export interface RickAndMortyApiInterface {
  info: Info;
  results: Result[];
}
