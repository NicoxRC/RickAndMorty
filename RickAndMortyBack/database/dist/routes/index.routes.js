"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const controller_1 = __importDefault(require("../controller"));
const express_1 = require("express");
const router = (0, express_1.Router)();
router.get('/characters', controller_1.default.charactersList);
router.get('/characters/:id', controller_1.default.character);
router.get('/locations', controller_1.default.locationsList);
router.get('/locations/:id', controller_1.default.location);
router.get('/episodes', controller_1.default.epidosesList);
router.get('/episodes/:id', controller_1.default.episode);
exports.default = router;
