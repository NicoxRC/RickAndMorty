import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/characters', controller.charactersList);
router.get('/locations', controller.locationsList);

export default router;
