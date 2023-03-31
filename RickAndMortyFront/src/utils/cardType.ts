import type { Result } from './resultsApiInterface';

export type CardType = Pick<
  Result,
  'id' | 'name' | 'status' | 'origin' | 'image'
>;
