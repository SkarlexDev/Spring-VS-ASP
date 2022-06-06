
namespace ASPNET_Student.Data
{
#pragma warning disable CS8618
    public class ApplicationDbContext : DbContext
    {

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {

        }

        public DbSet<Student> students { get; set; }
    }
#pragma warning restore CS8618
}
