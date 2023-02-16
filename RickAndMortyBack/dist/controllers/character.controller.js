"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.deleteCharacter = exports.postCharacter = exports.getCharacter = exports.getCharacters = void 0;
const Character_1 = require("../models/Character");
const getCharacters = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const characters = yield Character_1.Character.findAll();
        res.status(200).json(characters);
    }
    catch (error) {
        res.status(404).json(error);
    }
});
exports.getCharacters = getCharacters;
const getCharacter = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { id } = req.params;
        const character = yield Character_1.Character.findByPk(id);
        if (!character)
            throw new Error('Bad Request.');
        res.status(200).json(character);
    }
    catch (error) {
        res.status(404).json(error);
    }
});
exports.getCharacter = getCharacter;
const postCharacter = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { name, status, species, type, gender, image } = req.body;
        if (!name || !status || !species || !gender)
            throw new Error('Bad Request.');
        const newCharacter = yield Character_1.Character.create({
            name,
            status,
            species,
            type,
            gender,
            image,
        });
        res.status(201).json(newCharacter);
    }
    catch (error) {
        res.status(400).json(error);
    }
});
exports.postCharacter = postCharacter;
const deleteCharacter = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { id } = req.params;
        const character = yield Character_1.Character.findByPk(id);
        if (!character)
            throw new Error('Bad Request.');
        yield character.destroy();
        res.status(202).json({ msg: 'Accepted.' });
    }
    catch (error) {
        res.status(404).json(error);
    }
});
exports.deleteCharacter = deleteCharacter;
