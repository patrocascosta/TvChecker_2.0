<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Serie extends Model
{
    protected $fillable =['nome_serie', 'descricao', 'imdb', 'image', 'id_categoria'];
}
