import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/characters', controller.charactersList);
router.get('/characters/:id', controller.character);
router.get('/locations', controller.locationsList);
router.get('/locations/:id', controller.location);
router.get('/episodes', controller.epidosesList);
router.get('/episodes/:id', controller.episode);

export default router;
