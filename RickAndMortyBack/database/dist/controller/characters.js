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
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.character = exports.charactersList = void 0;
const connection_1 = __importDefault(require("../connection"));
const charactersList = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const response = yield connection_1.default.Character.find()
            .populate('origin', ['_id', 'name'])
            .populate('location', ['_id', 'name'])
            .populate('episode', ['_id', 'name']);
        res.status(200).json(response);
    }
    catch (error) {
        error instanceof Error
            ? res.status(400).json({ error: error.message })
            : null;
    }
});
exports.charactersList = charactersList;
const character = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const { id } = req.params;
        const response = yield connection_1.default.Character.findById(id)
            .populate('origin', ['_id', 'name'])
            .populate('location', ['_id', 'name'])
            .populate('episode', ['_id', 'name']);
        res.status(200).json(response);
    }
    catch (error) {
        error instanceof Error
            ? res.status(400).json({ error: error.message })
            : null;
    }
});
exports.character = character;
