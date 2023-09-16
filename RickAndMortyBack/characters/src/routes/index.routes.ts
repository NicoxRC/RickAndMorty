import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/characters', controller.getCharactersList);

export default router;
