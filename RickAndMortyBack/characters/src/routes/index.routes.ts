import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/characters', controller.getCharactersList);
router.get('/characters/:id', controller.getCharacter);

export default router;
