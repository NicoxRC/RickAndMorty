import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/locations', controller.getLocationsList);
router.get('/locations/:id', controller.getLocation);

export default router;
