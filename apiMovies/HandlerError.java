** Ejemplos para el manejo de error en el Controller

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


@GetMapping("/{postId}/comments/{commentId}")
public Comment getPostComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId)
{
    	return commentRepository.findById(commentId)
    			.orElseThrow(() -> new ResourceNotFoundException("No comment found with id="+commentId));
}


