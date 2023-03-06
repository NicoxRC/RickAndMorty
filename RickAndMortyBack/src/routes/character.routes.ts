import { Router } from 'express';
import {
  getCharactersDB,
  getCharacter,
  postCharacter,
  deleteCharacter,
} from '../controllers/character.controller';

const router = Router();

router.get('/charactersdb', getCharactersDB);
router.post('/characters', postCharacter);
router.get('/characters/:id', getCharacter);
router.delete('/characters/:id', deleteCharacter);

export default router;
