import { Router } from 'express';
import {
  getCharacters,
  getCharacter,
  postCharacter,
  deleteCharacter,
} from '../controllers/character.controller';

const router = Router();

router.get('/characters', getCharacters);
router.post('/characters', postCharacter);
router.get('/characters/:id', getCharacter);
router.delete('/characters/:id', deleteCharacter);

export default router;
