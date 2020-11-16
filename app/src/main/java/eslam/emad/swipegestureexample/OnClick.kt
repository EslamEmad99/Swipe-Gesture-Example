package eslam.emad.swipegestureexample

interface OnClick {

    fun onItemClick(book: Book)

    fun onEditClick(book: Book)

    fun onShareClick(book: Book)

    fun onDeleteClick(book: Book)

    fun onLocationClick(book: Book)
}