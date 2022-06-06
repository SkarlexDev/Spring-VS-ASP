
namespace ASPNET_Student.Models
{
#pragma warning disable CS8618 // Non-nullable field must contain a non-null value when exiting constructor. Consider declaring as nullable.
    [Index(nameof(Email), IsUnique = true)]
    public class Student
    {
        [Key]
        [Display(Name ="Id")]
        public int Id { get; set; }

        [Required]
        public string FirstName { get; set; }

        [Required]
        public string LastName { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        public string Phone { get; set; }
       
        [Required]
        public string Address { get; set; }

        [Required]
        public string City { get; set; }

        [Required]
        public int StudyYear { get; set; }
        public int Age { get; set; }

        public override string ToString()
        {
            return "Id: " + Id + " First name: " + FirstName + ", Last name: " + LastName + ", City: " + City;
        }
    }
#pragma warning restore CS8618 // Non-nullable field must contain a non-null value when exiting constructor. Consider declaring as nullable.
}
