** Ejemplos para el manejo de error en las capas: Controller/Service
//ClienteService.java ----------------------------------------------------------------------------------------------------------
@Override
public Optional<Cliente> consultarCliente(int idC) {
	return Optional.ofNullable(repCliente.findById(idC).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue encontrado")));	
}



---------------------------------------------------------------------------------------------------------------------------------
@DeleteMapping("/{id}")
public void deletePost(@PathVariable("id") Integer id)
{
        Post post = postRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("No post found with id="+id));
        try {
		postRepository.deleteById(post.getId());
	} catch (Exception e) {
		throw new PostDeletionException("Post with id="+id+" can't be deleted");
	}        
}

@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<UserRest> get(@PathVariable String userId) {
        if (DataBase.USER_MAP.containsKey(userId))
            return new ResponseEntity<>(DataBase.USER_MAP.get(userId), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


@GetMapping("/{postId}/comments/{commentId}")
public Comment getPostComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId)
{
    	return commentRepository.findById(commentId)
    			.orElseThrow(() -> new ResourceNotFoundException("No comment found with id="+commentId));
}

@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<UserRest> create(@Valid @RequestBody UserRest userRest) {
    System.out.println(userRest);
    userRest.setUserId("");
    return new ResponseEntity<>(userRest, HttpStatus.OK);
}


@DeleteMapping(value="/users/{id}")
ResponseEntity<String> delete(@PathVariable("id") @Min(1) int id) {
    User user = userrepo.findById(id)
                       .orElseThrow(()->new ResourceNotFoundException("User with ID :"+id+" Not Found!"));
                
    userrepo.deleteById(user.getId());
    return ResponseEntity.ok().body("User deleted with success!");      
}
