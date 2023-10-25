import type { CharactersInterface } from '../interfaces/characters';

export type CardPropsType = Pick<
  CharactersInterface,
  'id' | 'name' | 'status' | 'origin' | 'image'
>;
