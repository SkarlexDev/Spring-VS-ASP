using ASPNET_Student.Data.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ASPNET_Student.Controllers
{
    public class StudentsController : Controller
    {
        private readonly IStudentsService _service;
        public StudentsController(IStudentsService service)
        {
            _service = service;
        }

        // GET: StudentsController
        public ActionResult Index()
        {
            var data = _service.GetAll();
            return View(data);
        }

        // GET: StudentsController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: StudentsController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind("FirstName,LastName,Email,Phone,Address,City,StudyYear,Age")]Student student)
        {
            if (!ModelState.IsValid)
            {
                return View(student);
            }
            
            if(_service.GetByEmail(student.Email)!=null)
            {
                // fail update mail already exist
                ModelState.AddModelError("Email", "The user email already exists");
                return View(student);
            }
            _service.Add(student);
            return RedirectToAction(nameof(Index));
            
        }

        // Get: StudentsController/Details/5

        public IActionResult Details(int id)
        {
            var studentDetails = _service.GetById(id);

            if(studentDetails == null)
            {
                return RedirectToAction(nameof(Index));
            }
            return View(studentDetails);

        }

        // GET: StudentsController/Edit/5
        public ActionResult Edit(int id)
        {
            var studentDetails = _service.GetById(id);

            if (studentDetails == null)
            {
                return RedirectToAction(nameof(Index));
            }
            return View(studentDetails);
        }

        // POST: StudentsController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, [Bind("Id,FirstName,LastName,Email,Phone,Address,City,StudyYear,Age")] Student student)
        {
            if(!ModelState.IsValid)
            {
                return View(student);
            }

            try
            {
                _service.Update(id, student);
                return RedirectToAction(nameof(Index));
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("Email", "The user email already exists try something else");
                return View(student);
            }
           
        }

        // GET: StudentsController/Delete/5
        public ActionResult Delete(int id)
        {
            var studentDetails = _service.GetById(id);

            if (studentDetails == null)
            {
                return RedirectToAction(nameof(Index));
            }
            return View(studentDetails);
        }

        // POST: StudentsController/Delete/5
        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            var studentDetails = _service.GetById(id);
            if(studentDetails == null)
            {
                return RedirectToAction(nameof(Index));
            }

            _service.Delete(id);
            return RedirectToAction(nameof(Index));

        }
    }
}
