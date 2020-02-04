<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Favoritos extends Model
{
    protected $fillable =['idUser', 'idSerie','favorito','idFavorito','image'];
}
